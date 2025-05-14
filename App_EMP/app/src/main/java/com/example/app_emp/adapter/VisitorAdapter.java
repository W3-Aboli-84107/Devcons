package com.example.app_emp.adapter;

public class VisitorAdapter extends RecyclerView.Adapter<VisitorAdapter.VisitorViewHolder> {

    private List<Visitor> visitorList;
    private Context context;

    public VisitorAdapter(List<Visitor> visitors, Context context) {
        this.visitorList = visitors;
        this.context = context;
    }

    @NonNull
    @Override
    public VisitorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.visitor_item, parent, false);
        return new VisitorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VisitorViewHolder holder, int position) {
        Visitor visitor = visitorList.get(position);
        holder.nameTextView.setText(visitor.name);

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, VisitorDetailActivity.class);
            intent.putExtra("visitor_id", visitor.id);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return visitorList.size();
    }

    public static class VisitorViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;

        public VisitorViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.tvVisitorName);
        }
    }
}
